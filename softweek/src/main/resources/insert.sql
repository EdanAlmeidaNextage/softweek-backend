--Insert de Categorias
INSERT INTO CATEGORIA (NOME, ATIVO, COR)
VALUES
    ('CAMISETAS', TRUE, 'AZUL'),
    ('CALÇAS', TRUE, 'PRETO'),
    ('JAQUETAS', TRUE, 'CINZA'),
    ('VESTIDOS', TRUE, 'VERMELHO'),
    ('SAPATOS', TRUE, 'MARROM');


--Insert de Subcategorias
INSERT INTO SUBCATEGORIA (ID_CATEGORIA, NOME, ATIVO, COR)
VALUES
    (1, 'CAMISAS DE ALGODÃO', TRUE, 'VERDE'),
    (1, 'CAMISAS POLO', TRUE, 'AMARELO'),
    (2, 'CALÇAS JEANS', TRUE, 'AZUL'),
    (2, 'CALÇAS DE MOLETOM', TRUE, 'CINZA'),
    (3, 'JAQUETAS DE INVERNO', TRUE, 'MARRON'),
    (3, 'JAQUETAS LEVES', TRUE, 'LARANJA'),
    (4, 'VESTIDOS LONGOS', TRUE, 'VIOLETA'),
    (4, 'VESTIDOS CURTOS', TRUE, 'ROSA'),
    (5, 'SAPATOS DE SALTO', TRUE, 'PRETO'),
    (5, 'SAPATOS CASUAL', TRUE, 'BRANCO');


--Insert de Produtos
-- Produtos para CAMISETAS
INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, ATIVO, ID_SUBCATEGORIA) VALUES
    ('Camiseta Básica de Algodão', 'Camiseta básica em algodão com diversas cores', 29.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'CAMISAS DE ALGODÃO')),
    ('Camiseta Estampada de Algodão', 'Camiseta de algodão com estampa criativa', 34.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'CAMISAS DE ALGODÃO')),
    ('Camisa Polo de Algodão', 'Camisa polo de algodão confortável', 49.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'CAMISAS POLO')),
    ('Camisa Polo Estampada', 'Camisa polo com estampa moderna', 54.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'CAMISAS POLO'));

-- Produtos para CALÇAS
INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, ATIVO, ID_SUBCATEGORIA) VALUES
    ('Calça Jeans Skinny', 'Calça jeans skinny com ajuste perfeito', 89.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'CALÇAS JEANS')),
    ('Calça Jeans Cargo', 'Calça jeans cargo com bolsos laterais', 99.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'CALÇAS JEANS')),
    ('Calça de Moletom Confortável', 'Calça de moletom para o dia a dia', 59.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'CALÇAS DE MOLETOM')),
    ('Calça de Moletom com Estampa', 'Calça de moletom com estampa divertida', 64.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'CALÇAS DE MOLETOM'));

-- Produtos para JAQUETAS
INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, ATIVO, ID_SUBCATEGORIA) VALUES
    ('Jaqueta de Inverno Impermeável', 'Jaqueta impermeável ideal para o inverno', 199.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'JAQUETAS DE INVERNO')),
    ('Jaqueta de Inverno com Forro', 'Jaqueta quentinha com forro', 229.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'JAQUETAS DE INVERNO')),
    ('Jaqueta Leve para Primavera', 'Jaqueta leve ideal para o clima de primavera', 119.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'JAQUETAS LEVES')),
    ('Jaqueta Leve com Capuz', 'Jaqueta leve com capuz removível', 134.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'JAQUETAS LEVES'));

-- Produtos para VESTIDOS
INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, ATIVO, ID_SUBCATEGORIA) VALUES
    ('Vestido Longo Estampado', 'Vestido longo com estampa vibrante', 129.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'VESTIDOS LONGOS')),
    ('Vestido Longo de Malha', 'Vestido longo em malha confortável', 139.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'VESTIDOS LONGOS')),
    ('Vestido Curto de Verão', 'Vestido curto ideal para o verão', 89.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'VESTIDOS CURTOS')),
    ('Vestido Curto de Festa', 'Vestido curto para festas e eventos', 149.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'VESTIDOS CURTOS'));

-- Produtos para SAPATOS
INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, ATIVO, ID_SUBCATEGORIA) VALUES
    ('Sapato de Salto Alto', 'Sapato de salto alto elegante', 199.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'SAPATOS DE SALTO')),
    ('Sapato de Salto Baixo', 'Sapato de salto baixo confortável', 179.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'SAPATOS DE SALTO')),
    ('Tênis Casual', 'Tênis casual para o dia a dia', 129.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'SAPATOS CASUAL')),
    ('Sapatilha Casual', 'Sapatilha casual leve e confortável', 89.90, TRUE, (SELECT id FROM SUBCATEGORIA WHERE nome = 'SAPATOS CASUAL'));
