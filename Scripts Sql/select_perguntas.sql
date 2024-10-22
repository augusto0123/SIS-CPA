SELECT 
r.id as id_resposta, r.resposta_objetiva, r.resposta_subjetiva, r.id_pergunta,
p.id, p.tipo, p.descricao, p.id_grupo_perguntas,
g.id, g.tipo, g.descricao, g.id_questionario,
q.id, q.categoria, q.descricao, q.id_avaliacao,
a.id, a.tema, a.descricao, a.id_edicao_autoavaliacao,
e.id, e.edicao, e.descricao, e.id_instituicao,
u.id, u.nome, u.id_instituicao,
i.id, i.nome_fantasia
from resposta r
INNER JOIN pergunta p 
ON r.id_pergunta = p.id
INNER JOIN grupo_perguntas g
ON p.id_grupo_perguntas = g.id
INNER JOIN questionario q
ON g.id_questionario = q.id
INNER JOIN avaliacao a
ON q.id_avaliacao = a.id
INNER JOIN edicao_autoavaliacao e
ON a.id_edicao_autoavaliacao = e.id
INNER JOIN instituicao i
ON e.id_instituicao = i.id
INNER JOIN usuario u
ON r.id_usuario = u.id;