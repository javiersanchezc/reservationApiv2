-- Inserción de hoteles
INSERT INTO hotels (name, location) VALUES ('Barranquilla', 'Barranquilla Location');
INSERT INTO hotels (name, location) VALUES ('Cali', 'Cali Location');
INSERT INTO hotels (name, location) VALUES ('Cartagena', 'Cartagena Location');
INSERT INTO hotels (name, location) VALUES ('Bogotá', 'Bogotá Location');

-- Inserción de habitaciones
-- Nota: El ID de los hoteles puede variar dependiendo de tu base de datos, asegúrate de insertar los valores correctos
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (1, 'standard', 30, 4);
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (1, 'premium', 3, 4);
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (2, 'premium', 20, 6);
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (2, 'vip', 2, 6);
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (3, 'standard', 10, 8);
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (3, 'premium', 1, 8);
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (4, 'standard', 20, 6);
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (4, 'premium', 20, 6);
INSERT INTO rooms (hotel_id, room_type, quantity, max_occupancy) VALUES (4, 'vip', 2, 6);


-- Inserción de reservas (booking)
-- Nota: Los ID de los hoteles y las habitaciones pueden variar dependiendo de tu base de datos, asegúrate de insertar los valores correctos
-- Asegúrate de cambiar las fechas a valores válidos para tu base de datos
INSERT INTO bookings (hotel_id, room_id, start_date, end_date, number_of_people) VALUES (1, 1, '2023-06-01', '2023-06-07', 2);
INSERT INTO bookings (hotel_id, room_id, start_date, end_date, number_of_people) VALUES (2, 3, '2023-07-01', '2023-07-07', 4);

-- Inserción de tarifas (rates)
-- Nota: Los ID de los hoteles pueden variar dependiendo de tu base de datos, asegúrate de insertar los valores correctos
INSERT INTO rates (hotel_id, room_type, season, price) VALUES (1, 'standard', 'low', 100.0);
INSERT INTO rates (hotel_id, room_type, season, price) VALUES (1, 'premium', 'low', 150.0);
INSERT INTO rates (hotel_id, room_type, season, price) VALUES (1, 'standard', 'high', 150.0);
INSERT INTO rates (hotel_id, room_type, season, price) VALUES (1, 'premium', 'high', 200.0);
INSERT INTO rates (hotel_id, room_type, season, price) VALUES (2, 'premium', 'low', 200.0);
INSERT INTO rates (hotel_id, room_type, season, price) VALUES (2, 'vip', 'low', 300.0);
INSERT INTO rates (hotel_id, room_type, season, price) VALUES (2, 'premium', 'high', 250.0);
INSERT INTO rates (hotel_id, room_type, season, price) VALUES (2, 'vip', 'high', 350.0);
