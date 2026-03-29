create table carts
(
    id           binary(16) default (uuid_to_bin(uuid())) not null primary key,
    date_created date       default (curdate())  not null
);

CREATE TABLE cart_items
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY ,
    cart_id BINARY(16) NOT NULL,
    product_id  BIGINT NOT NULL,
    quantity    int DEFAULT 1 NOT NULL,
    constraint cart_items_carts_id_fk
        foreign key (cart_id) references carts (id) ON DELETE CASCADE,
    constraint cart_items_product_id_fk
        foreign key (product_id) references products (id) ON DELETE CASCADE,
    constraint uc_cart_product
        unique (cart_id, product_id)
);
