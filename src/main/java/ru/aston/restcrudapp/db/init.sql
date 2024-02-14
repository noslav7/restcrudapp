DROP TABLE IF EXISTS disabled;
DROP TABLE IF EXISTS employees_projects;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS projects;

CREATE TABLE employees(
id SERIAL PRIMARY KEY,
name VARCHAR(255),
department VARCHAR(255)
);

TRUNCATE TABLE employees RESTART IDENTITY;

CREATE TABLE projects(
id SERIAL PRIMARY KEY,
category VARCHAR(255) UNIQUE
);

TRUNCATE TABLE projects RESTART IDENTITY;
/**
 * Между колонками таблиц employees и projects связь One-to-Many.
 * Связь реализуется посредством таблицы employees_projects.
 */
CREATE TABLE employees_projects(
    employee_id INTEGER UNIQUE REFERENCES employees(id),
    project_id INTEGER REFERENCES projects(id)
);
/**
 * Между колонками таблиц disabled и employees связь One-to-One.
 */
CREATE TABLE disabled(
id SERIAL UNIQUE PRIMARY KEY,
employee_id INTEGER UNIQUE REFERENCES employees(id)
);

TRUNCATE TABLE disabled RESTART IDENTITY;





