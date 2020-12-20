db.createUser(
    {
        user: "app_user",
        pwd: "Q1W2e3r4",
        roles: [
            {
                "role": "read",
                "db": "banco"
            },
            {
                "role": "readWrite",
                "db": "banco"
            },
            {
                "role": "dbAdmin",
                "db": "banco"
            },
            {
                "role": "userAdmin",
                "db": "banco"
            }
        ]
    }
);


db.getCollection('faixa_cheque_especial').insert({
    "nome" : "FAIXA_1",
    "score" : [0, 1],
    "limite" : 0
});

db.getCollection('faixa_cheque_especial').insert({
    "nome" : "FAIXA_2",
    "score" : [2, 3, 4, 5],
    "limite" : 1000
});

db.getCollection('faixa_cheque_especial').insert({
    "nome" : "FAIXA_3",
    "score" : [6, 7, 8],
    "limite" : 2000
});

db.getCollection('faixa_cheque_especial').insert({
    "nome" : "FAIXA_4",
    "score" : [9],
    "limite" : 5000
});

db.getCollection('faixa_cartao_credito').insert({
    "nome" : "FAIXA_1",
    "score" : [0, 1],
    "limite" : 0
});

db.getCollection('faixa_cartao_credito').insert({
    "nome" : "FAIXA_2",
    "score" : [2, 3, 4, 5],
    "limite" : 200
});

db.getCollection('faixa_cartao_credito').insert({
    "nome" : "FAIXA_3",
    "score" : [6, 7, 8],
    "limite" : 2000
});

db.getCollection('faixa_cartao_credito').insert({
    "nome" : "FAIXA_4",
    "score" : [9],
    "limite" : 15000
});