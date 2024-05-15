INSERT INTO product (description, name, price, stock) VALUES 
('BMW Seria 3, 320d, diesel, 2019, gri, cutie automată', 'BMW Seria 3', 35000.00, 8),
('Audi A4 Avant, 2.0 TFSI, benzina, 2020, alb, cutie automată', 'Audi A4 Avant', 42000.00, 6),
('Mercedes-Benz Clasa E, E220d, diesel, 2021, negru, cutie automată', 'Mercedes-Benz Clasa E', 48000.00, 10),
('Toyota Corolla Hybrid, 1.8, hibrid, 2020, albastru, cutie automată', 'Toyota Corolla Hybrid', 30000.00, 12),
('Tesla Model S Long Range, electric, 2022, alb, autonomie 630 km', 'Tesla Model S', 85000.00, 5),
('Porsche 911 Carrera 4S, 3.0, benzina, 2021, rosu, cutie automată', 'Porsche 911 Carrera 4S', 130000.00, 3),
('Ford Mustang GT, 5.0 V8, benzina, 2020, galben, cutie manuală', 'Ford Mustang GT', 55000.00, 7),
('Jaguar F-Type R-Dynamic, 5.0 V8, benzina, 2021, negru, cutie automată', 'Jaguar F-Type R-Dynamic', 90000.00, 4),
('Land Rover Defender 110, diesel, 2022, verde, cutie automată', 'Land Rover Defender 110', 60000.00, 9),
('Ferrari 488 Pista, 3.9 V8, benzina, 2021, rosu, cutie automată', 'Ferrari 488 Pista', 300000.00, 2);

UPDATE product
SET image_path = '/Images/BMW.jpg'
WHERE id = 1;

UPDATE product
SET image_path = '/Images/Audi.jpg'
WHERE id = 2;

UPDATE product
SET image_path = '/Images/Mercedes-Benz.jpg'
WHERE id = 3;

UPDATE product
SET image_path = '/Images/Toyota.jpg'
WHERE id = 4;

UPDATE product
SET image_path = '/Images/Tesla.jpg'
WHERE id = 5;

UPDATE product
SET image_path = '/Images/Porche.jpg'
WHERE id = 6;

UPDATE product
SET image_path = '/Images/Ford.jpg'
WHERE id = 7;

UPDATE product
SET image_path = '/Images/Jaguar.jpg'
WHERE id = 8;

UPDATE product
SET image_path = '/Images/Land_Rover.jpg'
WHERE id = 9;

UPDATE product
SET image_path = '/Images/Ferrari.jpg'
WHERE id = 10;



