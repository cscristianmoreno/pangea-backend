CREATE TABLE IF NOT EXISTS municipes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(72) NOT NULL UNIQUE,
    phone VARCHAR(15) DEFAULT NULL,
    location VARCHAR(96) DEFAULT NULL,
    person_in_charge VARCHAR(32) DEFAULT NULL,
    logistic_in_charge VARCHAR(32) DEFAULT NULL,
    logistic_phone VARCHAR(15) DEFAULT NULL,
    product_deposit VARCHAR(56) DEFAULT NULL,
    register TIMESTAMP(6) DEFAULT NOW()::TIMESTAMP(6)
);

CREATE TABLE IF NOT EXISTS services (
    id SERIAL PRIMARY KEY,
    municipe_id INTEGER NOT NULL,
    name VARCHAR(56) DEFAULT NULL,
    description TEXT DEFAULT NULL,
    buyer_name VARCHAR(56) DEFAULT NULL,
    register TIMESTAMP(6) DEFAULT NOW()::TIMESTAMP(6),

    CONSTRAINT fk_municipe_id FOREIGN KEY(municipe_id) REFERENCES municipes(id)
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    email VARCHAR(32) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(16) NOT NULL,
    member_state VARCHAR(32) DEFAULT NULL,
    buyer_direction VARCHAR(32) DEFAULT NULL,
    seller_direction VARCHAR(32) DEFAULT NULL,
    register TIMESTAMP(6) DEFAULT NOW()::TIMESTAMP(6)
);

CREATE TABLE IF NOT EXISTS producers (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    -- product_id INTEGER NOT NULL,
    description VARCHAR(72) DEFAULT NULL,
    expertice TEXT DEFAULT NULL,
    company_name VARCHAR(72) DEFAULT NULL,
    company_description VARCHAR(128) DEFAULT NULL,
    register TIMESTAMP(6) DEFAULT NOW()::TIMESTAMP(6),

    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS consumers (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    -- service_id INTEGER NOT NULL,
    description VARCHAR(32) DEFAULT NULL,
    register TIMESTAMP(6) DEFAULT NOW()::TIMESTAMP(6),

    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(id)
    -- CONSTRAINT fk_service_id FOREIGN KEY(service_id) REFERENCES services(id)
);

CREATE TABLE IF NOT EXISTS administrators (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE,
    register TIMESTAMP(6) DEFAULT NOW()::TIMESTAMP(6),

    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(id)
);  

CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    producer_id INTEGER NOT NULL,
    name VARCHAR(72) DEFAULT NULL,
    description TEXT DEFAULT NULL,
    state BOOLEAN DEFAULT false,
    register TIMESTAMP(6) DEFAULT NOW()::TIMESTAMP(6),

    CONSTRAINT fk_producer_id FOREIGN KEY(producer_id) REFERENCES producers(id)
);

-- ALTER TABLE producers ADD CONSTRAINT fk_product_id FOREIGN KEY(product_id) REFERENCES products(id);