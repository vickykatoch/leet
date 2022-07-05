class Color {
    LightenColor(color: string, percent: number) {
        var num = parseInt(color.replace("#",""),16),
        amt = Math.round(2.55 * percent),
        R = (num >> 16) + amt,
        B = (num >> 8 & 0x00FF) + amt,
        G = (num & 0x0000FF) + amt;
        return "#" + (0x1000000 + (R<255?R<1?0:R:255)*0x10000 + (B<255?B<1?0:B:255)*0x100 + (G<255?G<1?0:G:255)).toString(16).slice(1);
    }
    getContrast50(hexcolor: string){
        return (parseInt(hexcolor, 16) > 0xffffff/2) ? 'black':'white';
    }

    getColor(color: string, percent: number) {
        const num = parseInt(color.replace("#",""),16);
        const amt = Math.round(2.55 * percent);
        const r = (num >> 16) + amt;
        const g = (num & 0x0000FF) + amt;
        const b = (num >> 8 & 0x00FF) + amt;

        const R = (r < 255 ? r < 1 ? 0 : r : 255)*0x10000;
        const G = (g < 255 ? g < 1 ? 0 : g : 255);
        const B = (b < 255 ? b < 1 ? 0 : b : 255)*0x100;

        
        const bg= `#${(0x1000000+R+B+G).toString(16).slice(1)}`;
        const num1 = parseInt(bg.replace("#",""),16);
        const r1 = (num1 >> 16) + amt;
        const g1 = (num1 & 0x0000FF) + amt;
        const b1 = (num1 >> 8 & 0x00FF) + amt;
        const fg = (Math.round(r1 * 299) + Math.round(g1 * 587) + Math.round(b1 * 114)) / 1000;

        return {
            bg,
            fg:(fg >= 128) ? 'black' : 'white'
        };
    }
}

export default new Color();
