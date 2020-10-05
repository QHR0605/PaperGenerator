/**
 * �ϴ�����
 *
 * @param url {string} �����ַ
 * @param method {string} POST/GET
 * @param payload {Object} ��������
 * @return {Object} ��ȡ�ķ��������
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