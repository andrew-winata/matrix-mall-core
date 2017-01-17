-- Database: matrix_mall

-- DROP DATABASE matrix_mall;

CREATE DATABASE matrix_mall
  WITH OWNER = dba
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;
	   
-- Table: mtx_user

-- DROP TABLE mtx_user;

CREATE TABLE mtx_user
(
  id character varying(255) NOT NULL,
  username character varying(100) NOT NULL,
  password character varying(100) NOT NULL,
  type smallint NOT NULL,
  email character varying(100) NOT NULL,
  name character varying(255) NOT NULL,
  is_delete boolean NOT NULL DEFAULT false,
  created_date timestamp without time zone,
  created_by character varying(255),
  updated_date timestamp without time zone,
  updated_by character varying(255),
  optlock bigint,
  CONSTRAINT pk_mtx_user PRIMARY KEY (id),
  CONSTRAINT uk_username UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mtx_user
  OWNER TO dba;
  
-- Table: mtx_customer

-- DROP TABLE mtx_customer;

CREATE TABLE mtx_customer
(
  id character varying(255) NOT NULL,
  address character varying(255),
  phone_number character varying(25),
  CONSTRAINT pk_mtx_customer PRIMARY KEY (id),
  CONSTRAINT fk_mtx_user FOREIGN KEY (id)
      REFERENCES mtx_user (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mtx_customer
  OWNER TO dba;
  
-- Table: mtx_category

-- DROP TABLE mtx_category;

CREATE TABLE mtx_category
(
  id character varying(255) NOT NULL,
  name character varying(255) NOT NULL,
  category_code character varying(50) NOT NULL,
  is_delete boolean NOT NULL DEFAULT false,
  optlock bigint,
  CONSTRAINT pk_mtx_category PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mtx_category
  OWNER TO dba;
  
-- Table: mtx_merchant

-- DROP TABLE mtx_merchant;

CREATE TABLE mtx_merchant
(
  id character varying(255) NOT NULL,
  store_name character varying(255) NOT NULL,
  store_address character varying(255) NOT NULL,
  store_phone_number character varying(25) NOT NULL,
  merchant_code character varying(50) NOT NULL,
  is_active boolean NOT NULL DEFAULT false,
  is_delete boolean NOT NULL DEFAULT false,
  created_date timestamp without time zone,
  created_by character varying(255),
  updated_date timestamp without time zone,
  updated_by character varying(255),
  optlock bigint,
  CONSTRAINT pk_mtx_merchant PRIMARY KEY (id),
  CONSTRAINT uk_merchant_code UNIQUE (merchant_code)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mtx_merchant
  OWNER TO dba;
  
-- Table: mtx_user_merchant

-- DROP TABLE mtx_user_merchant;

CREATE TABLE mtx_user_merchant
(
  user_id character varying(255) NOT NULL,
  merchant_id character varying(255) NOT NULL,
  id character varying(255) NOT NULL,
  CONSTRAINT pk_mtx_user_merchant PRIMARY KEY (id),
  CONSTRAINT fk_mtx_merchant FOREIGN KEY (merchant_id)
      REFERENCES mtx_merchant (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_mtx_user FOREIGN KEY (user_id)
      REFERENCES mtx_user (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mtx_user_merchant
  OWNER TO dba;
  
-- Table: mtx_merchant_product

-- DROP TABLE mtx_merchant_product;

CREATE TABLE mtx_merchant_product
(
  id character varying(255) NOT NULL,
  merchant_id character varying(255) NOT NULL,
  product_sku character varying(50) NOT NULL,
  sale_stock integer NOT NULL DEFAULT 0,
  sale_price double precision NOT NULL,
  product_name character varying(255) NOT NULL,
  product_description text,
  is_delete boolean NOT NULL DEFAULT false,
  category_code character varying(50) NOT NULL,
  created_date timestamp without time zone,
  created_by character varying(255),
  updated_date timestamp without time zone,
  updated_by character varying(255),
  optlock bigint,
  CONSTRAINT pk_mtx_merchant_product PRIMARY KEY (id),
  CONSTRAINT fk_mtx_merchant FOREIGN KEY (merchant_id)
      REFERENCES mtx_merchant (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mtx_merchant_product
  OWNER TO dba;
  
-- Table: mtx_order

-- DROP TABLE mtx_order;

CREATE TABLE mtx_order
(
  id character varying(255) NOT NULL,
  created_date timestamp without time zone,
  created_by character varying(255),
  updated_date timestamp without time zone,
  updated_by character varying(255),
  customer_name character varying(255),
  customer_address character varying(255),
  customer_phone_number character varying(25),
  status character varying(5),
  optlock bigint,
  CONSTRAINT pk_mtx_order PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mtx_order
  OWNER TO dba;
  
-- Table: mtx_order_item

-- DROP TABLE mtx_order_item;

CREATE TABLE mtx_order_item
(
  id character varying(255) NOT NULL,
  order_id character varying(255) NOT NULL,
  item_sku character varying(50) NOT NULL,
  item_name character varying(255) NOT NULL,
  item_price double precision NOT NULL,
  item_qty integer NOT NULL,
  item_total_price double precision NOT NULL,
  category_code character varying(50) NOT NULL,
  category_name character varying(255),
  merchant_code character varying(50) NOT NULL,
  merchant_name character varying(255),
  merchant_address character varying(255),
  merchant_phone_number character varying(25),
  optlock bigint,
  CONSTRAINT pk_mtx_order_item PRIMARY KEY (id),
  CONSTRAINT fk_mtx_order FOREIGN KEY (order_id)
      REFERENCES mtx_order (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mtx_order_item
  OWNER TO dba;

INSERT INTO mtx_user(
            id, username, password, type, email, name, is_delete, created_date, 
            created_by, updated_date, updated_by, optlock)
    VALUES ('5916d053-95c7-4eed-8aa0-cbfbf14040c0', 'admin@matrix-mall.com', 'master', 1, 'andrew.winata@gdn-commerce.com', 'Admin', false, now(), 
            'script', now(), 'script', 0);
