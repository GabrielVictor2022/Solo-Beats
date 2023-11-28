
document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault();
    
    const nomeCompleto = document.getElementById("nomeCompleto").value;
    const email = document.getElementById("email").value;
    const endereco = document.getElementById("endereco").value;
    const cidade = document.getElementById("cidade").value;
    const estado = document.getElementById("estado").value;
    const cep = document.getElementById("cep").value;
    const nomeCartao = document.getElementById("nomeCartao").value;
    const numeroCartao = document.getElementById("numeroCartao").value;
    const mesVencimento = document.getElementById("mesVencimento").value;
    const anoVencimento = document.getElementById("anoVencimento").value;
    const cvv = document.getElementById("cvv").value;

    const userData = {
        nomeCompleto: nomeCompleto,
        email: email,
        endereco: endereco,
        cidade: cidade,
        estado: estado,
        cep: cep,
        nomeCartao: nomeCartao,
        numeroCartao: numeroCartao,
        mesVencimento: mesVencimento,
        anoVencimento: anoVencimento,
        cvv: cvv
    };

    fetch('http://localhost:3030/checkout', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Registration failed');
        }
        return response.json();
    })
    .then(data => {
        console.log('Registration successful:', data);
    })
    .catch(error => {
        console.error('Error during registration:', error);
    });
    
});