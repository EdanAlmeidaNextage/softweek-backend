-- Produtos para CAMISETAS
INSERT INTO produto (nome, descricao, preco, ativo, id_subcategoria, criado_por, data_criacao, ultima_modificacao_por, ultima_data_modificada)
VALUES
    ('Camiseta Básica de Algodão', 'Camiseta básica em algodão com diversas cores', 29.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'CAMISAS DE ALGODÃO'),
     'admin', NOW(), 'admin', NOW()),
    ('Camiseta Estampada de Algodão', 'Camiseta de algodão com estampa criativa', 34.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'CAMISAS DE ALGODÃO'),
     'admin', NOW(), 'admin', NOW()),
    ('Camisa Polo de Algodão', 'Camisa polo de algodão confortável', 49.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'CAMISAS POLO'),
     'admin', NOW(), 'admin', NOW()),
    ('Camisa Polo Estampada', 'Camisa polo com estampa moderna', 54.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'CAMISAS POLO'),
     'admin', NOW(), 'admin', NOW());

-- Produtos para CALÇAS
INSERT INTO produto (nome, descricao, preco, ativo, id_subcategoria, criado_por, data_criacao, ultima_modificacao_por, ultima_data_modificada)
VALUES
    ('Calça Jeans Skinny', 'Calça jeans skinny com ajuste perfeito', 89.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'CALÇAS JEANS'),
     'admin', NOW(), 'admin', NOW()),
    ('Calça Jeans Cargo', 'Calça jeans cargo com bolsos laterais', 99.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'CALÇAS JEANS'),
     'admin', NOW(), 'admin', NOW()),
    ('Calça de Moletom Confortável', 'Calça de moletom para o dia a dia', 59.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'CALÇAS DE MOLETOM'),
     'admin', NOW(), 'admin', NOW()),
    ('Calça de Moletom com Estampa', 'Calça de moletom com estampa divertida', 64.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'CALÇAS DE MOLETOM'),
     'admin', NOW(), 'admin', NOW());

-- Produtos para JAQUETAS
INSERT INTO produto (nome, descricao, preco, ativo, id_subcategoria, criado_por, data_criacao, ultima_modificacao_por, ultima_data_modificada)
VALUES
    ('Jaqueta de Inverno Impermeável', 'Jaqueta impermeável ideal para o inverno', 199.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'JAQUETAS DE INVERNO'),
     'admin', NOW(), 'admin', NOW()),
    ('Jaqueta de Inverno com Forro', 'Jaqueta quentinha com forro', 229.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'JAQUETAS DE INVERNO'),
     'admin', NOW(), 'admin', NOW()),
    ('Jaqueta Leve para Primavera', 'Jaqueta leve ideal para o clima de primavera', 119.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'JAQUETAS LEVES'),
     'admin', NOW(), 'admin', NOW()),
    ('Jaqueta Leve com Capuz', 'Jaqueta leve com capuz removível', 134.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'JAQUETAS LEVES'),
     'admin', NOW(), 'admin', NOW());

-- Produtos para VESTIDOS
INSERT INTO produto (nome, descricao, preco, ativo, id_subcategoria, criado_por, data_criacao, ultima_modificacao_por, ultima_data_modificada)
VALUES
    ('Vestido Longo Estampado', 'Vestido longo com estampa vibrante', 129.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'VESTIDOS LONGOS'),
     'admin', NOW(), 'admin', NOW()),
    ('Vestido Longo de Malha', 'Vestido longo em malha confortável', 139.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'VESTIDOS LONGOS'),
     'admin', NOW(), 'admin', NOW()),
    ('Vestido Curto de Verão', 'Vestido curto ideal para o verão', 89.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'VESTIDOS CURTOS'),
     'admin', NOW(), 'admin', NOW()),
    ('Vestido Curto de Festa', 'Vestido curto para festas e eventos', 149.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'VESTIDOS CURTOS'),
     'admin', NOW(), 'admin', NOW());

-- Produtos para SAPATOS
INSERT INTO produto (nome, descricao, preco, ativo, id_subcategoria, criado_por, data_criacao, ultima_modificacao_por, ultima_data_modificada)
VALUES
    ('Sapato de Salto Alto', 'Sapato de salto alto elegante', 199.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'SAPATOS DE SALTO'),
     'admin', NOW(), 'admin', NOW()),
    ('Sapato de Salto Baixo', 'Sapato de salto baixo confortável', 179.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'SAPATOS DE SALTO'),
     'admin', NOW(), 'admin', NOW()),
    ('Tênis Casual', 'Tênis casual para o dia a dia', 129.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'SAPATOS CASUAL'),
     'admin', NOW(), 'admin', NOW()),
    ('Sapatilha Casual', 'Sapatilha casual leve e confortável', 89.90, TRUE,
     (SELECT id FROM subcategoria WHERE nome = 'SAPATOS CASUAL'),
     'admin', NOW(), 'admin', NOW());
