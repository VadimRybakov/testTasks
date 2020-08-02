-- PostgreSQL

CREATE SCHEMA nums ;

CREATE TABLE values_tbl (
                            values_id INT NOT NULL,
                            PRIMARY KEY (values_id));

INSERT INTO values_tbl (values_id) SELECT generate_series(1,20);
DELETE FROM values_tbl WHERE random() < 0.3 ;

CREATE SCHEMA nums ;

SELECT *FROM values_tbl;

CREATE VIEW from_index AS(
                         SELECT v1.values_id
                         FROM values_tbl AS v1
                                  LEFT JOIN values_tbl AS v2
                                            ON v1.values_id = v2.values_id-1
                         WHERE v2.values_id IS NULL);

CREATE VIEW to_index AS(
                       SELECT v1.values_id
                       FROM values_tbl AS v1
                                LEFT JOIN values_tbl AS v2
                                          ON v1.values_id = v2.values_id+1
                       WHERE v2.values_id IS NULL);

SELECT *FROM from_index;
SELECT *FROM to_index;


