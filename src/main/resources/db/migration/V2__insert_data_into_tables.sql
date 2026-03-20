INSERT INTO countries (name, continent)
VALUES ('Macedonia', 'Europe'),
       ('Serbia', 'Europe'),
       ('Croatia', 'Europe'),
       ('Germany', 'Europe'),
       ('France', 'Europe'),
       ('Italy', 'Europe');

INSERT INTO hosts (created_at, updated_at, name, surname, country_id)
VALUES (NOW(), NOW(), 'Aleksandar', 'Petrov', 1),
       (NOW(), NOW(), 'Marija', 'Jovanovska', 1),
       (NOW(), NOW(), 'Ivan', 'Nikolic', 2),
       (NOW(), NOW(), 'Stefan', 'Müller', 4),
       (NOW(), NOW(), 'Sophie', 'Dubois', 5),
       (NOW(), NOW(), 'Luca', 'Rossi', 6);

INSERT INTO accommodations (created_at, updated_at, name, category, condition, rented, num_rooms, host_id)
VALUES (NOW(), NOW(), 'Cozy Room in Skopje Center', 'ROOM', 'GOOD', FALSE, 1, 1),
       (NOW(), NOW(), 'Modern Flat near City Park', 'FLAT', 'GOOD', FALSE, 2, 1),
       (NOW(), NOW(), 'Family House in Aerodrom', 'HOUSE', 'GOOD', FALSE, 4, 2),
       (NOW(), NOW(), 'Studio Apartment Vodno View', 'APARTMENT', 'GOOD', FALSE, 1, 2),
       (NOW(), NOW(), 'Budget Room Belgrade', 'ROOM', 'BAD', FALSE, 1, 3),
       (NOW(), NOW(), 'Luxury Hotel Suite Zagreb', 'HOTEL', 'GOOD', TRUE, 3, 3),
       (NOW(), NOW(), 'Mountain Motel Kopaonik', 'MOTEL', 'GOOD', FALSE, 2, 3),
       (NOW(), NOW(), 'Berlin City Apartment', 'APARTMENT', 'GOOD', FALSE, 2, 4),
       (NOW(), NOW(), 'Paris Studio Flat', 'FLAT', 'GOOD', TRUE, 1, 5),
       (NOW(), NOW(), 'Rome Holiday House', 'HOUSE', 'GOOD', FALSE, 5, 6);

INSERT INTO reviews (created_at, updated_at, comment, rating, accommodation_id)
VALUES (NOW(), NOW(), 'Very cozy and clean room, great location!', 4.5, 1),
       (NOW(), NOW(), 'Nice stay, but a bit noisy at night.', 4.0, 1),
       (NOW(), NOW(), 'Modern and spacious flat, perfect for two.', 4.8, 2),
       (NOW(), NOW(), 'Good location, slightly expensive.', 4.2, 2),
       (NOW(), NOW(), 'Perfect for a family, lots of space.', 4.7, 3),
       (NOW(), NOW(), 'Clean and comfortable, but a bit far from the center.', 4.3, 3),
       (NOW(), NOW(), 'Amazing view of Vodno, very quiet.', 4.9, 4),
       (NOW(), NOW(), 'Small but comfortable.', 4.0, 4),
       (NOW(), NOW(), 'Cheap option, not very clean.', 2.5, 5),
       (NOW(), NOW(), 'Room is small, but the location is convenient.', 3.0, 5),
       (NOW(), NOW(), 'Extremely luxurious, worth the price!', 5.0, 6),
       (NOW(), NOW(), 'Staff was friendly, amenities were top-notch.', 4.8, 6),
       (NOW(), NOW(), 'Perfect mountain retreat, cozy rooms.', 4.6, 7),
       (NOW(), NOW(), 'Good breakfast, but wifi was weak.', 4.2, 7),
       (NOW(), NOW(), 'Modern apartment in a great location.', 4.7, 8),
       (NOW(), NOW(), 'Nice stay, clean and well-furnished.', 4.5, 8),
       (NOW(), NOW(), 'Cute studio in the heart of Paris.', 4.9, 9),
       (NOW(), NOW(), 'Tiny but perfect for a weekend.', 4.3, 9),
       (NOW(), NOW(), 'Spacious house, great for large groups.', 4.8, 10),
       (NOW(), NOW(), 'Lovely garden and terrace, very peaceful.', 4.6, 10);