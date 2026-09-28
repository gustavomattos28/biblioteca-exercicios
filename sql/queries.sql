SELECT codigo, titulo, tipo, disponivel
FROM item;

SELECT u.nome, i.titulo
FROM emprestimo e
JOIN usuario u ON e.usuario_id = u.id
JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL;

SELECT u.nome, SUM(e.valor_multa) AS total_multas
FROM emprestimo e
JOIN usuario u ON e.usuario_id = u.id
GROUP BY u.nome;

SELECT i.titulo
FROM item i
LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.id IS NULL;