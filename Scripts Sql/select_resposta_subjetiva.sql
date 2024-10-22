select r.* from resposta r
INNER JOIN pergunta p 
ON r.id_pergunta = p.id
INNER JOIN grupo_perguntas g
ON p.id_grupo_perguntas = g.id
INNER JOIN questionario q
ON g.id_questionario = q.id
INNER JOIN avaliacao a
ON q.id_avaliacao = a.id
where a.id = 1 and r.resposta_subjetiva is not null and r.resposta_subjetiva != '';