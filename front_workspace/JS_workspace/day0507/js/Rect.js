class Rect {
    constructor(container, posX, posY, width, height, color) {
        this.container = container;
        this.div = document.createElement("div");
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.color = color;

        this.div.style.position = "absolute";
        this.div.style.left = this.posX + "px";
        this.div.style.top = this.posY + "px";
        this.div.style.width = this.width + "px";
        this.div.style.height = this.height + "px";
        this.div.style.backgroundColor = this.color;

        this.container.appendChild(this.div);
        this.move();
    }

    move() {
        // this.div.style.height = getRandom(this.height) + "px";
        this.div.style.height = parseFloat(this.div.style.height) + 0.1 * (getRandom(this.height) - parseFloat(this.div.style.height)) + "px";

        setTimeout(() => {
            this.move();
        }, 400);
    }
}
