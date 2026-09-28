CREATE TABLE item (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(100),
    edicao VARCHAR(20),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(15) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INTEGER NOT NULL
);

CREATE TABLE emprestimo (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INTEGER NOT NULL REFERENCES item(id),
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(6,2) DEFAULT 0
);

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('L001', 'Dom Casmurro', 'livro', 'Machado de Assis', '3a edicao', FALSE),
('L002', '1984', 'livro', 'George Orwell', '1a edicao', TRUE),
('R001', 'Superinteressante', 'revista', NULL, 'edicao 405', FALSE),
('R002', 'Veja', 'revista', NULL, 'edicao 2812', TRUE);

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Gustavo', 'aluno', 3),
('Ana Paula', 'professor', 5);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
(1, 1, '2026-09-01', '2026-09-15', NULL, 0),
(3, 2, '2026-08-20', '2026-08-27', '2026-08-30', 3.00);