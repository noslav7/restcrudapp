DROP TABLE IF EXISTS disabled;
DROP TABLE IF EXISTS employees_projects;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS projects;

CREATE TABLE employees(
id SERIAL PRIMARY KEY,
name VARCHAR(255) UNIQUE,
department VARCHAR(255)
);

TRUNCATE TABLE employees RESTART IDENTITY;

CREATE TABLE projects(
id SERIAL PRIMARY KEY,
category VARCHAR(255) UNIQUE
);

TRUNCATE TABLE projects RESTART IDENTITY;
/*
 Между колонками таблиц employees(id) и projects(id) связь One-to-Many.
 Связь реализуется посредством таблицы employees_projects.
 */
CREATE TABLE employees_projects(
    employee_id INTEGER UNIQUE,
    project_id INTEGER
);
/**
 * Между колонками таблиц disabled(employee_id) и employees(id) связь One-to-One.
 */
CREATE TABLE disabled(
id SERIAL UNIQUE PRIMARY KEY,
employee_id INTEGER UNIQUE
);

TRUNCATE TABLE disabled RESTART IDENTITY;





