const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  // Proxy to shellymadrid.com
  app.use(
    '/api',
    createProxyMiddleware({
      target: 'http://127.0.0.1:8080',
      changeOrigin: true,
      pathRewrite: {
        '^/api': '', // Remove /api prefix before sending to target
      },
    })
  );

  // Proxy to another server, e.g., https://another-server.com
  app.use(
    '/sm',
    createProxyMiddleware({
      target: 'https://shellymadrid.com',
      changeOrigin: true,
      pathRewrite: {
        '^/sm': '', // Remove /another-api prefix before sending to target
      },
    })
  );
};
