{-#LANGUAGE GADTs, EmptyDataDecls, EmptyCase #-}
{-# OPTIONS_GHC -fno-warn-tabs #-}

module Lab1 where
import Prelude (Show)

data Bool where {   False :: Bool; True :: Bool; } deriving Show

-- Funcion not
not :: Bool -> Bool
not = \b -> case b of {
    True -> False;
    False -> True;
}


--Funcion or
(||) :: Bool -> Bool -> Bool 
(||) = \b1 -> \b2 ->  case b1 of {
                    True -> True;
                    False -> b2;
}
-- Funcion  &&
(&&) :: Bool -> Bool -> Bool 
(&&) = \b1 -> \b2  ->  case b1 of {
                    True -> b2;
                    False -> False;
}

-- Funcion xor
xor :: Bool -> Bool -> Bool 
xor = \b1 -> \b2  ->  case b1 of {
                    True -> not b2;
                    False -> b2;
}

-- Funcion  >>
(>>) :: Bool -> Bool -> Bool 
(>>) = \b1 -> \b2  ->  case b1 of {
                    True -> b2;
                    False -> True;
}

(==) :: Bool -> Bool -> Bool
(==) = \b1 -> \b2 -> case b1 of {
                    True ->  b2;
                    False -> not b2; 
}

(===) :: Bool -> Bool -> Bool
(===) = \b1 -> \b2 -> (b1 && b2) || (not b1 && not b2) ;
-- not (xor b1 b2)
--- b1 >> b2 && b2 >> b1

(/=) :: Bool -> Bool -> Bool
(/=) = \b1 -> \b2 -> case b1 of {
                    True -> not b2;
                    False -> b2; 
}


(/==) :: Bool -> Bool -> Bool
(/==) = \b1 -> \b2 -> not (b1 == b2)

(<=) :: Bool -> Bool -> Bool
(<=) = (>>)

--Ejercicio 4
unanimidad :: Bool -> Bool -> Bool -> Bool
unanimidad = \b1 -> b2 -> \b3 -> ((b1 && b2 & b3) || (not b1 && not b2 && not b3)

unanimidad2 :: Bool -> Bool -> Bool -> Bool
unanimidad2 = \b1 -> \b2 -> \b3 -> case b1 of {
    True -> case b2 of {
        True -> b3;
        False -> False;
    };
    False -> case b2 of {
        True -> False;
        False -> not b3;
    };
}

mayoria :: Bool -> Bool -> Bool -> Bool 
mayoria  = \b1 -> b2 -> \b3 -> case b1 of {
                            True -> case b2 of {
                                True -> True;
                                False -> b3
                            };
                            False -> case b2 of {
                                True  -> b3;
                                False -> True;
                            }

}
impar :: Bool -> Bool -> Bool -> Bool 
impar  = \b1 -> b2 -> \b3 -> case b1 of {
                            True -> case b2 of {
                                True -> b3;
                                False -> not b3;
                            };
                            False -> case b2 of {
                                True  -> not b3;
                                False -> b3;
                            };

}


--Ejerccicio 5
(&&&) :: Bool -> Bool -> Bool 
(&&&) =\b1 -> \b2 ->  not ((not b1) || (not b2))

(>>>) :: Bool -> Bool -> Bool 
(>>>) =\b1 -> \b2 ->   not b1 ||  b2
      
