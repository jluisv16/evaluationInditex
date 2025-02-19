
-- Marcas de Inditex
INSERT INTO brand (id, name) VALUES (1, 'Zara');
INSERT INTO brand (id, name) VALUES (2, 'Massimo Dutti');

-- Productos
INSERT INTO product (id, name) VALUES (1, 'Abrigo Lino');
INSERT INTO product (id, name) VALUES (35455, 'Camisa Seda');


INSERT INTO price (id, brand_id, product_id,
start_date, end_date, price_list, priority, price, currency)
VALUES (1, 1, 35455, null,
null, 1, 0, 35.50, 'EUR');