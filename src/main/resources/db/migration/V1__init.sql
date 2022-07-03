
DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles(
                           id bigserial PRIMARY KEY,
                           title varchar(30) not null unique
);

DROP TABLE IF EXISTS users;
CREATE TABLE users(
                      id bigserial PRIMARY KEY,
                      login varchar(30) not null unique,
                      password varchar(80) not null,
                      email varchar (80) unique,
                      first_name varchar(80) not null,
                      last_name varchar(80) not null,
                      birthday_date date,
                      created_at timestamp default current_timestamp,
                      updated_at timestamp,
                      is_active boolean default true,
                      role_id integer REFERENCES user_roles(id)
);


DROP TABLE IF EXISTS locations;
CREATE TABLE locations(
                           id bigserial PRIMARY KEY,
                           title varchar(30) not null unique,
                           description varchar(240),
                           full_description varchar(540),
                           adress varchar(120),
                           work_time_start time,
                           work_time_end time,
                           link_image varchar(240),
                           latitude DOUBLE PRECISION,
                           longitude DOUBLE PRECISION,
                           created_at timestamp default current_timestamp,
                           updated_at timestamp,
                           link_site varchar(240)
);

DROP TABLE IF EXISTS categories_for_locations;
CREATE TABLE categories_for_locations(
                                         id bigserial PRIMARY KEY,
                                         title varchar(30) not null unique,
                                         description varchar(240)
);

DROP TABLE IF EXISTS locations_categories;
CREATE TABLE locations_categories(
                                     location_id integer REFERENCES locations(id),
                                     category_id integer REFERENCES categories_for_locations(id)
);

DROP TABLE IF EXISTS events;
CREATE TABLE events(
                       id bigserial PRIMARY KEY,
                       title varchar(30) not null unique,
                       description varchar(240),
                       start_datetime timestamp,
                       finish_datetime timestamp,
                       link_event_site varchar(240),
                       price integer,
                       location_id integer REFERENCES locations(id),
                       created_at timestamp default current_timestamp,
                       updated_at timestamp,
                       is_active boolean default true,
                       user_created_id integer REFERENCES users(id)
);

DROP TABLE IF EXISTS categories_for_events;
CREATE TABLE categories_for_events(
                                       id bigserial PRIMARY KEY,
                                       title varchar(30) not null unique,
                                       description varchar(240)
);

DROP TABLE IF EXISTS event_categories;
CREATE TABLE event_categories(
                                 event_id integer REFERENCES events(id),
                                 category_id integer REFERENCES categories_for_events(id)
);

DROP TABLE IF EXISTS user_events;
CREATE TABLE user_events(
                             id bigserial PRIMARY KEY,
                             user_id integer REFERENCES users(id),
                             event_id integer REFERENCES events(id)
);

DROP TABLE IF EXISTS user_events_info;
CREATE TABLE user_events_info(
                                  id bigserial PRIMARY KEY,
                                  user_events_id integer REFERENCES user_events(id),
                                  favorites boolean default false,
                                  visited boolean default false
);

DROP TABLE IF EXISTS categories_for_routes;
CREATE TABLE categories_for_routes(
                                      id bigserial PRIMARY KEY,
                                      title varchar(30) not null unique,
                                      description varchar(240)
);

DROP TABLE IF EXISTS categories_for_users;
CREATE TABLE categories_for_users(
                                     id bigserial PRIMARY KEY,
                                     title varchar(30) not null unique,
                                     description varchar(240)
);

DROP TABLE IF EXISTS users_categories;
CREATE TABLE users_categories(
                                 user_id integer REFERENCES users(id),
                                 category_id integer REFERENCES categories_for_users(id)
);

DROP TABLE IF EXISTS routes;
CREATE TABLE routes(
                       id bigserial PRIMARY KEY,
                       title varchar(30) not null unique,
                       description varchar(240),
                       duration time,
                       distanse bigint,
                       routes_categories_id integer REFERENCES categories_for_routes(id),
                       user_created_id integer REFERENCES users(id),
                       created_at timestamp default current_timestamp,
                       updated_at timestamp
);

DROP TABLE IF EXISTS routes_locations;
CREATE TABLE routes_locations(
                                  route_id bigserial REFERENCES routes(id),
                                  location_id integer REFERENCES locations(id)
);

DROP TABLE IF EXISTS user_routes;
CREATE TABLE user_routes(
                             id bigserial PRIMARY KEY,
                             user_id integer REFERENCES users(id),
                             route_id integer REFERENCES routes(id)
);

DROP TABLE IF EXISTS user_routes_info;
CREATE TABLE user_routes_info(
                                  id bigserial PRIMARY KEY,
                                  user_routes_id integer REFERENCES user_events(id),
                                  favorites boolean default false,
                                  visited boolean default false
);

DROP TABLE IF EXISTS offer_categories;
CREATE TABLE offer_categories(
                                  id bigserial PRIMARY KEY,
                                  title varchar(30) not null unique
);

DROP TABLE IF EXISTS offers;
CREATE TABLE offers(
                        id bigserial PRIMARY KEY,
                        user_created_id integer REFERENCES users(id),
                        event_id integer REFERENCES events(id),
                        location_id integer REFERENCES locations(id),
                        user_received_id integer REFERENCES users(id),
                        title varchar(30) not null unique,
                        description varchar(240),
                        created_at timestamp default current_timestamp,
                        updated_at timestamp,
                        is_active boolean,
                        offer_categories_id integer REFERENCES offer_categories(id)
);
