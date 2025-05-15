class HP {
    constructor(container, x, y, w, h, bg, borderColor) {
        this.container = container;
        this.div = document.createElement("div");
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.bg = bg;
        this.borderColor = borderColor;

        this.div.style.position = "absolute";
        this.div.style.left = this.x + "px";
        this.div.style.top = this.y + "px";
        this.div.style.width = this.w + "px";
        this.div.style.height = this.h + "px";
        this.div.style.backgroundColor = bg;
        this.div.style.borderColor = "1px solid " + this.borderColor;

        this.container.appendChild(this.div);
    }
}
