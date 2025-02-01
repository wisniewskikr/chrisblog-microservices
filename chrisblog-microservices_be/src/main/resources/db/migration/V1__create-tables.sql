CREATE TABLE CATEGORY (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE TAG (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE ARTICLE (
    id INT PRIMARY KEY,
    page_description TEXT,
    title VARCHAR(255),
    description TEXT,
    date DATE,
    author VARCHAR(100),
    category_id INT,
    template VARCHAR(50),
    url VARCHAR(500),
    content VARCHAR(5000)
);

CREATE TABLE ARTICLE_TAG (
    tag_id INT NOT NULL,
    article_id INT NOT NULL,
    PRIMARY KEY (tag_id, article_id),
    FOREIGN KEY (tag_id) REFERENCES TAG(id) ON DELETE CASCADE,
    FOREIGN KEY (article_id) REFERENCES ARTICLE(id) ON DELETE CASCADE
);