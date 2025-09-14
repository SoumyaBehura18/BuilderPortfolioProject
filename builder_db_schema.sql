--DATABASE--
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100),
    password VARCHAR(100),
    role VARCHAR(50)
);


CREATE TABLE projects (
    project_id SERIAL PRIMARY KEY,
    project_name VARCHAR(100),
    builder_id INTEGER REFERENCES users(user_id),
    client_id INTEGER REFERENCES users(user_id),
    manager_id INTEGER REFERENCES users(user_id),
    budget NUMERIC,
    actual_spend NUMERIC,
    status VARCHAR(50)
);


CREATE TABLE project_documents (
    document_id SERIAL PRIMARY KEY,
    project_id INTEGER REFERENCES projects(project_id),
    user_id INTEGER REFERENCES users(user_id),
    file_name VARCHAR(100),
    file_path VARCHAR(255)
);
