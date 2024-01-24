CREATE TABLE hotel
 (
     hotel_id SERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     description TEXT,
     address VARCHAR(255),
     has_parking BOOLEAN,
     has_wifi BOOLEAN
 );
 CREATE TABLE room
  (
     room_id SERIAL PRIMARY KEY,
     room_number INTEGER NOT NULL,
     category VARCHAR(50),
     capacity INTEGER,
     price DECIMAL(10, 2)
 );
CREATE TABLE reservation
 (
    reservation_id SERIAL PRIMARY KEY,
    room_id INTEGER REFERENCES room(room_id),
    guest_name VARCHAR(255) NOT NULL,
    checkin_date DATE,
    checkout_date DATE,
    total_price DECIMAL(10, 2)
);
