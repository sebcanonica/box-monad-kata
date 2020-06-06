-- Generic computation applicable in any monad
process :: Monad m =>  m String -> m String -> m String
process mx my = do
   x <- mx
   y <- my
   return (x++y)

-- In the Maybe monad
ma = Just "a"
mb = Just "b"
mN = Nothing

p1 = process ma mb
p2 = process ma mN

-- In the IO monad
pio :: IO String
pio = process getLine getLine

--In the List monad
lC = ["a","b","c"]
lN = ["1","2","3"]

pL = process lC lN

-- Desugaring do notation to classic functional
desugaredProcess :: Monad m =>  m String -> m String -> m String
desugaredProcess mx my = 
    mx >>= (\x ->
        my >>= (\y -> 
            pure (x++y)
        )
    )

dpL = desugaredProcess lC lN