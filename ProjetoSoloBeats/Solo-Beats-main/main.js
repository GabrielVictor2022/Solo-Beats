
// header 
let header = document.querySelector('header');


window.addEventListener('scroll', () => {
    header.classList.toggle('shadow', window.scrollY > 0);
});

//Menu
let menu = document.querySelector('#menu-icon');
let navbar = document.querySelector('.navbar');

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navbar.classList.toggle('active');
}

// remove o menu
window.onscroll = () => {
    menu.classList.toggle('bx-x');
    navbar.classList.remove('active');
}

//Scroll Reveal Animation
const sr = ScrollReveal({
    origin: 'top',
    distance: '60px',
    duration: 2500,
    delay: 400,
    //reset: true
})

// Função para abrir o carrinho
function openCart() {
    const cartContainer = document.querySelector(".cart-container");
    cartContainer.style.display = "block";
}

// Função para fechar o carrinho
function closeCart() {
    const cartContainer = document.querySelector(".cart-container");
    cartContainer.style.display = "none";
}

// Função para adicionar item ao carrinho
function addToCart(productName, price, imageSrc) {
    const cartItems = document.querySelector(".cart-items");
    const li = document.createElement("li");

    const itemInfo = document.createElement("div");
    itemInfo.classList.add("item-info");

    // Nome do produto
    const productNameElement = document.createElement("span");
    productNameElement.textContent = productName;
    productNameElement.classList.add("product-name");

    // Preço do produto
    const priceElement = document.createElement("span");
    priceElement.textContent = `R$${349}`;
    priceElement.classList.add("product-price");

    // Imagem do produto
    const productImage = document.createElement("img");
    productImage.src = imageSrc;
    productImage.alt = productName;
    productImage.classList.add("product-image");

    itemInfo.appendChild(productNameElement);
    itemInfo.appendChild(priceElement);
    itemInfo.appendChild(productImage);

    // Criar botões "+" e "-" para ajustar a quantidade
    const plusButton = document.createElement("button");
    plusButton.textContent = "+";
    plusButton.classList.add("quantity-button");
    plusButton.addEventListener("click", () => increaseQuantity(li, priceElement));

    const minusButton = document.createElement("button");
    minusButton.textContent = "-";
    minusButton.classList.add("quantity-button");
    minusButton.addEventListener("click", () => decreaseQuantity(li, priceElement));

    // Inicializar a quantidade
    const quantity = document.createElement("span");
    quantity.textContent = "1";
    quantity.classList.add("product-quantity");

    // Criar botão de lixeira
    const trashButton = document.createElement("button");
    trashButton.innerHTML = '<i class="fas fa-trash"></i>';
    trashButton.classList.add("remove-button");
    trashButton.addEventListener("click", () => removeItem(li, priceElement));

    li.appendChild(itemInfo); // Adiciona o nome e o preço antes dos botões
    li.appendChild(quantity);
    li.appendChild(plusButton);
    li.appendChild(minusButton);
    li.appendChild(trashButton);

    li.classList.add("cart-item");

    cartItems.appendChild(li);
    openCart();

    updateTotalPrice();
}

// Função para aumentar a quantidade e recalcular o preço total
function increaseQuantity(item, priceElement) {
    const quantityElement = item.querySelector(".product-quantity");
    if (quantityElement && priceElement) {
        let currentQuantity = parseInt(quantityElement.textContent);
        let price = parseFloat(priceElement.textContent.replace('R$', ''));
        const originalQuantity = currentQuantity; // Armazena a quantidade original

        currentQuantity++;
        price += parseFloat(priceElement.textContent.replace('R$', '')) / originalQuantity; // Adicione o preço original dividido pela quantidade original

        quantityElement.textContent = currentQuantity;
        priceElement.textContent = `R$${price.toFixed(2)}`;
    }
    updateTotalPrice();
}

// Função para diminuir a quantidade e subtrair o preço total
function decreaseQuantity(item, priceElement) {
    const quantityElement = item.querySelector(".product-quantity");
    if (quantityElement && priceElement) {
        let currentQuantity = parseInt(quantityElement.textContent);
        let price = parseFloat(priceElement.textContent.replace('R$', ''));
        const originalQuantity = currentQuantity; // Armazena a quantidade original

        if (currentQuantity > 1) {
            currentQuantity--;
            price -= parseFloat(priceElement.textContent.replace('R$', '')) / originalQuantity; // Subtraia o preço original dividido pela quantidade original

            quantityElement.textContent = currentQuantity;
            priceElement.textContent = `R$${price.toFixed(2)}`;
        }
    }
    updateTotalPrice();
}

// Função para remover um item do carrinho
function removeItem(item, priceElement) {
    const cartItems = document.querySelector(".cart-items");
    cartItems.removeChild(item);

    if (priceElement) {
        // Subtrair o preço do item removido do preço total
        const totalPriceElement = document.querySelector(".total-price");
        let totalPrice = parseFloat(totalPriceElement.textContent.replace('R$', ''));
        totalPrice -= parseFloat(priceElement.textContent.replace('R$', ''));
        totalPriceElement.textContent = `R$${totalPrice.toFixed(2)}`;
    }
    updateTotalPrice();
}

// Função para atualizar o preço total
function updateTotalPrice() {
    const cartItems = document.querySelectorAll(".cart-item");
    let totalPrice = 0;

    cartItems.forEach((item) => {
        const priceElement = item.querySelector(".product-price");
        const quantityElement = item.querySelector(".product-quantity");

        if (priceElement && quantityElement) {
            const price = parseFloat(priceElement.textContent.replace('R$', ''));
            const quantity = parseInt(quantityElement.textContent);

            totalPrice += price;
        }
    });

    // Atualiza o elemento que exibe o preço total
    const totalPriceElement = document.querySelector(".total-price");
    totalPriceElement.textContent = `Total: R$${totalPrice.toFixed(2)}`;
}

// Função para iniciar o processo de checkout
function checkoutCart() {
    window.location.href = "checkout.html";
}

sr.reveal('.home-text,.buds-text', {origin: 'left'})
sr.reveal('.home-img,.buds-img',{origin: 'right'})
sr.reveal('.heading', {delay: 200})
sr.reveal('.specs-details .box', {origin: 'left', interval:100})
sr.reveal('.specs-img', {delay: 600})
sr.reveal('.shop-container .box,.footer .logo,.footer .footer-box', {interval:200})
