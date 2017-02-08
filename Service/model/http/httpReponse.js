/**
 * Created by Massil on 27/01/2017.
 */
var reponse = {
    status : 'String',
    data : 'Object'
};

module.exports = {
    setReponse : function(status , data)
    {
        reponse.data = data;
        reponse.status = status;
        return reponse;
    }
};