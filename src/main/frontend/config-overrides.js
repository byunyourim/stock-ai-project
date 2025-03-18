const webpack = require("webpack");

module.exports = function override(config) {
  config.resolve.fallback = {
    "process": require.resolve("process"),
    "stream": require.resolve("stream-browserify"),
    "buffer": require.resolve("buffer"),
    "crypto": require.resolve("crypto-browserify"),
    "util": require.resolve("util"),
  };

  config.plugins.push(
      new webpack.ProvidePlugin({
        process: "process",
        Buffer: ["buffer", "Buffer"],
      })
  );

  return config;
};
