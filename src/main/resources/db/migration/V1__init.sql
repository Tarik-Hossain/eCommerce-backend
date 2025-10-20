-- ======================= table Script===================
-- =========================================
-- E-commerce Database DDL + Master Data
-- =========================================

-- =========================
-- features/login -> users
-- =========================
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       full_name VARCHAR(100),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Sample users
INSERT INTO users (username, email, password, full_name)
VALUES
      ('admin', 'admin@example.com', 'admin123', 'Administrator'),
      ('john', 'john@example.com', 'john123', 'John Doe'),
      ('jane', 'jane@example.com', 'jane123', 'Jane Doe');

-- =========================
-- features/product -> products
-- =========================
CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          price NUMERIC(10,2) NOT NULL,
                          stock INT DEFAULT 0,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Sample products
INSERT INTO products (name, description, price, stock)
VALUES
   ('Laptop', 'High-performance laptop', 1200.00, 10),
   ('Smartphone', 'Latest model smartphone', 800.00, 25),
   ('Headphones', 'Noise-cancelling headphones', 150.00, 50),
   ('Keyboard', 'Mechanical keyboard', 70.00, 30),
   ('Mouse', 'Wireless mouse', 40.00, 50);

-- =========================
-- features/order -> orders and order_items
-- =========================
CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                        total_amount NUMERIC(10,2) NOT NULL,
                        status VARCHAR(50) DEFAULT 'PENDING',
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
                             id SERIAL PRIMARY KEY,
                             order_id INT NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
                             product_id INT NOT NULL REFERENCES products(id),
                             quantity INT NOT NULL,
                             price NUMERIC(10,2) NOT NULL
);

-- =========================
-- features/cart -> cart and cart_items
-- =========================
CREATE TABLE cart (
                      id SERIAL PRIMARY KEY,
                      user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cart_items (
                            id SERIAL PRIMARY KEY,
                            cart_id INT NOT NULL REFERENCES cart(id) ON DELETE CASCADE,
                            product_id INT NOT NULL REFERENCES products(id),
                            quantity INT NOT NULL
);


-- =========================
-- features/utility -> bills
-- =========================
CREATE TABLE bills (
                       id SERIAL PRIMARY KEY,
                       order_id INT NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
                       bill_number VARCHAR(50) UNIQUE NOT NULL,
                       amount NUMERIC(10,2) NOT NULL,
                       status VARCHAR(50) DEFAULT 'UNPAID',
                       paid_date TIMESTAMP
);


-- =========================
-- Optional Indexes
-- =========================
CREATE INDEX idx_orders_user_id ON orders(user_id);
CREATE INDEX idx_order_items_order_id ON order_items(order_id);
CREATE INDEX idx_cart_user_id ON cart(user_id);
CREATE INDEX idx_cart_items_cart_id ON cart_items(cart_id);
