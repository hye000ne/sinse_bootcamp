class Ball {
    constructor(container, posX, posY, width, height, velX, velY, color) {
        this.container = container;
        this.div = document.createElement("div");
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.velX = velX;
        this.velY = velY;
        this.color = color;

        this.div.style.position = "absolute";
        this.div.style.left = this.posX + "px";
        this.div.style.top = this.posY + "px";
        this.div.style.width = this.width + "px";
        this.div.style.height = this.height + "px";
        this.div.style.backgroundColor = this.color;
        this.div.style.borderRadius = 50 + "%";

        this.container.appendChild(this.div);
    }

    move() {
        if (this.posY >= 600 - this.height || this.posY <= 0) this.velY *= -1;
        if (this.posX >= 600 - this.width || this.posX <= 0) this.velX *= -1;

        this.posX += this.velX;
        this.posY += this.velY;

        this.div.style.left = this.posX + "px";
        this.div.style.top = this.posY + "px";
    }
}
