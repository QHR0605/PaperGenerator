/**
 * 上传数据
 *
 * @param url {string} 服务地址
 * @param method {string} POST/GET
 * @param payload {Object} 数据内容
 * @return {Object} 获取的服务端数据
 */
const upload = (url, method, payload) => {
    fetch(url, {
        method: method,
        body: JSON.stringify(payload)
    }).then(async resp => {
        return await resp.json();
    }).catch(err => {
        console.log(err);
    })
}