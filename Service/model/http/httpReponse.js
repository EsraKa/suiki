/**
 * Created by Massil on 27/01/2017.
 */
var reponse = {
    status : 'String',
    data : 'Object'
};

module.exports = {
    setReponse : function(status , data , err)
    {
        reponse.data = data;
        reponse.status = status;
        reponse.error = err;
        return reponse;
    },
    getReponse : function()
    {
        return reponse;
    }
};