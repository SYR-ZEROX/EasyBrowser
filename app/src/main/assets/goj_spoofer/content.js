// ========== Canvas Fingerprint ==========
const origToDataURL = HTMLCanvasElement.prototype.toDataURL;
HTMLCanvasElement.prototype.toDataURL = function() {
    const ctx = this.getContext('2d');
    if (ctx) {
        ctx.fillStyle = 'rgba(255,255,255,0.01)';
        ctx.fillText('GOJ_BROWSER', 0, 42);
    }
    return origToDataURL.apply(this, arguments);
};

// ========== WebGL Fingerprint ==========
const getParameter = WebGLRenderingContext.prototype.getParameter;
WebGLRenderingContext.prototype.getParameter = function(param) {
    if (param === 37445) return 'Qualcomm';
    if (param === 37446) return 'Adreno (TM) 740';
    return getParameter.apply(this, arguments);
};

// ========== Hardware ==========
Object.defineProperty(navigator, 'hardwareConcurrency', { get: () => 8 });
Object.defineProperty(navigator, 'deviceMemory', { get: () => 12 });
Object.defineProperty(navigator, 'platform', { get: () => 'Android' });

// ========== WebDriver ==========
Object.defineProperty(navigator, 'webdriver', { get: () => undefined });

// ========== WebRTC (احتياطي) ==========
delete window.RTCPeerConnection;
delete window.webkitRTCPeerConnection;
delete window.mozRTCPeerConnection;