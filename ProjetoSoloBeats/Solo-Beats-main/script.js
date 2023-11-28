const container = document.querySelector(".container");
const signUpLink = document.querySelector(".signup-link");
const signInLink = document.querySelector(".signin-link");

signUpLink.addEventListener("click", () => {
    container.classList.add("navigate");
});

signInLink.addEventListener("click", () => {
    container.classList.remove("navigate");
});

document.getElementById("iniciarSessaoButton").addEventListener("click", function() {
    window.location.href = "./index.html";
});

document.getElementById("criarContaButton").addEventListener("click", function () {
    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    const userData = {
        nome: nome,
        email: email,
        senha: senha
    };

    fetch('http://localhost:3030/usuario', {
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
        window.location.href = "index.html";
        // Optionally, you can redirect the user or perform other actions after successful registration
    })
    .catch(error => {
        console.error('Error during registration:', error);
    });

});

