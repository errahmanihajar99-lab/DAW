
-- exr 1
WITH RECURSIVE mes AS (
    SELECT DATE('2021-01-01') AS mes
    UNION ALL
    SELECT mes + INTERVAL 1 MONTH
    FROM mes
    WHERE mes < '2021-12-01'
)
SELECT m.mes AS mes_empl, COUNT(e.empleat_id) AS total_empleats
FROM mes m 
LEFT JOIN empleats e -- pour afficher tous les mois meme si le total_empleats est null
ON YEAR(m.mes) = YEAR(e.data_contractacio)
AND MONTH(m.mes) = MONTH(e.data_contractacio)
GROUP BY m.mes;

-- exr 2
WITH RECURSIVE mes AS (
		SELECT DATE(CONCAT(YEAR(CURDATE()),'-1-1')) AS mes
        UNION ALL 
        SELECT mes + INTERVAL 1 MONTH
        FROM mes
        WHERE mes < DATE(CONCAT(YEAR(CURDATE()),'-12-1'))
)
SELECT m.mes AS mes_empl, COUNT(e.empleat_id) AS total_empleats
FROM mes m 
LEFT JOIN empleats e -- pour afficher tous les mois meme si le total_empleats est null
ON YEAR(m.mes) = YEAR(e.data_contractacio)
AND MONTH(m.mes) = MONTH(e.data_contractacio)
GROUP BY m.mes;

-- exr 3
WITH RECURSIVE arbol AS (
		SELECT empleat_id, nom, cognoms, 0 AS nivell
        FROM empleats
        WHERE empleat_id = 149
        UNION ALL 
        SELECT e.empleat_id, e.nom, e.cognoms, a.nivell + 1
        FROM empleats e 
        INNER JOIN arbol a
        ON e.id_cap = a.empleat_id
)
SELECT * FROM arbol
ORDER BY nivell, empleat_id;

-- exr 4
WITH RECURSIVE mes AS (
		SELECT DATE('1999-01-01') AS mes
        UNION ALL
        SELECT mes + INTERVAL 1 MONTH
        FROM mes
        WHERE mes < DATE('1999-12-01')
)
SELECT m.mes AS mes_emp, COUNT(e.empleat_id) 
FROM mes m 
LEFT JOIN empleats e 
ON YEAR(e.data_contractacio) = YEAR(m.mes)
AND MONTH(e.data_contractacio) = MONTH(m.mes)
GROUP BY m.mes;
        
-- exr 5
-- exr 6
WITH RECURSIVE arbol AS (
		SELECT empleat_id, nom, cognoms, 0 AS nivell
        FROM empleats
        WHERE id_cap IS NULL
        UNION ALL
        SELECT e.empleat_id, e.nom, e.cognoms, a.nivell + 1 AS nivell
        FROM empleats e 
        INNER JOIN arbol a
        ON a.empleat_id = e.id_cap
)
SELECT * FROM arbol
ORDER BY nivell;

-- exr 7
WITH dep_stat AS (
		SELECT departament_id,
			   AVG(salari) AS mitja_salari,
               MAX(salari) AS max_salari,
               MIN(salari) AS min_salari
		FROM empleats
        GROUP BY departament_id
)
SELECT e.empleat_id,
		e.nom, e.cognoms, e.salari,
        ds.mitja_salari,
        ds.max_salari,
        ds.min_salari,
        (e.salari-ds.min_salari) AS dif_min,
        (ds.max_salari-e.salari) AS dif_max
FROM empleats e 
INNER JOIN dep_stat ds 
ON e.departament_id = ds.departament_id;