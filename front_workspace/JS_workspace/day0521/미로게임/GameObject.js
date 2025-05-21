class GameObject {
    constructor(container, x, y, w, h, velX, velY, bgc, bd, bdc) {
        this.container = container;
        this.div = document.createElement("div");
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.velX = velX;
        this.velY = velY;
        this.bgc = bgc;
        this.bd = bd;
        this.bdc = bdc;

        this.div.style.position = "absolute";
        this.div.style.left = this.x + "px";
        this.div.style.top = this.y + "px";
        this.div.style.width = this.w + "px";
        this.div.style.height = this.h + "px";
        this.div.style.backgroundColor = this.bgc;
        this.div.style.border = `${this.bd}px solid ${this.bdc}`;
        this.div.style.boxSizing = "border-box";

        this.container.appendChild(this.div);
    }

    tick() {}

    render() {}
}
