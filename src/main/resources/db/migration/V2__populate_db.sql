-- Insert clients
INSERT INTO client (name) VALUES
    ('Client 1'),
    ('Client 2'),
    ('Client 3'),
    ('Client 4'),
    ('Client 5'),
    ('Client 6'),
    ('Client 7'),
    ('Client 8'),
    ('Client 9'),
    ('Client 10');

-- Insert planets
INSERT INTO planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('EARTH', 'Earth'),
    ('JUPITER', 'Jupiter'),
    ('SATURN', 'Saturn');

-- Insert tickets
INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
    (CURRENT_TIMESTAMP, 1, 'MARS', 'VEN'),
    (CURRENT_TIMESTAMP, 2, 'VEN', 'EARTH'),
    (CURRENT_TIMESTAMP, 3, 'MARS', 'EARTH'),
    (CURRENT_TIMESTAMP, 4, 'EARTH', 'JUPITER'),
    (CURRENT_TIMESTAMP, 5, 'EARTH', 'SATURN'),
    (CURRENT_TIMESTAMP, 6, 'JUPITER', 'SATURN'),
    (CURRENT_TIMESTAMP, 7, 'MARS', 'SATURN'),
    (CURRENT_TIMESTAMP, 8, 'VEN', 'JUPITER'),
    (CURRENT_TIMESTAMP, 9, 'EARTH', 'MARS'),
    (CURRENT_TIMESTAMP, 10, 'SATURN', 'VEN');