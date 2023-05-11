CREATE SCHEMA IF NOT EXISTS trips;
CREATE SEQUENCE IF NOT EXISTS trips.table_ride_id_seq;

CREATE TABLE IF NOT EXISTS trips.ride
(
    id bigint NOT NULL DEFAULT nextval('trips.table_ride_id_seq'),
    start_date date NOT NULL,
    start_pickup_address varchar(255)  NOT NULL,
    start_pickup_location varchar(255) NOT NULL,
    end_date date,
    end_pickup_address varchar(255),
    end_pickup_location varchar(255),
    country_name varchar(255),
    city_name varchar(255),
    passenger_first_name varchar(255),
    passenger_last_name varchar(255),
    driver_first_name varchar(255) NOT NULL,
    driver_last_name varchar(255) NOT NULL,
    car_plate varchar(255) NOT NULL,
    status varchar(255) NOT NULL,
    check_code varchar(255),
    created_at date NOT NULL,
    updated_at date,
    price double precision NOT NULL,
    driver_location varchar(255),
    CONSTRAINT pk_ride PRIMARY KEY (id)
)
