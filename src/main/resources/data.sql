CREATE TABLE Suv (
  VIN VARCHAR(255) NOT NULL,
  MILAGE NUMERIC NOT NULL,
  LOCATION VARCHAR(255) NOT NULL,
  PRICE NUMERIC NOT NULL,
  PRIMARY KEY (VIN)
);

INSERT INTO Suv (vin, milage, location, price) VALUES ('ololo',2,'trololo',3);

CREATE TABLE Truck (
  VIN VARCHAR(255) NOT NULL,
  MILAGE NUMERIC NOT NULL,
  LOCATION VARCHAR(255) NOT NULL,
  PRICE NUMERIC NOT NULL,
  MAX_WEIGHT NUMERIC NOT NULL,
  PRIMARY KEY (VIN)
);