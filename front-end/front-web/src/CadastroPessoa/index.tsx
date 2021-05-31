import { FormEvent, useState } from "react";
import api from '../api';
import { useHistory } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';



function CadastroPessoa() {

    const [name, setName] = useState('');
    const [cpf, setCpf] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');
    const history = useHistory();
   
    var error = "Verifique os Campos com erros";
    async function CreateNewUser(event: FormEvent) {

        event.preventDefault()

        handleValidation(name, cpf, dataNascimento)

        if ({ handleValidation }) {

            api.post('api/cadastro', { name, email: cpf, password: dataNascimento})
                .then(res => {
                    console.log("cadastro efetuado")
                    history.push('/');
                    window.location.reload();

                });

        }

        function handleValidation(name: string, cpf: string, dataNascimento: String) {

            if (name === "") {
               
                SetError("Nome Obrigatório");
            }

            if (cpf === "") {
                SetError("cpf Obrigatório");
            }

            if (dataNascimento === "") {
                SetError("Data de Nascimento Obrigatório");
                
            }

        }

        

        return { handleValidation }

    }

    function NotifyError() {

        toast.error(error);

    }

    function SetError(errorMsg : string){
        error = errorMsg;

        return error;
    }


    return (
        <>
            <div className="container center">
                <div className="jumbotron text-center">
                    <h1>Cadastro Pessoa Física</h1>
                </div>
                <div className="row">
                    <div className="col-xs-4 col-md-6 col-md-offset-3">
                        <form className="form-horizontal" method="post" onSubmit={CreateNewUser}>
                            <div className="form-group">
                                <label className="col-sm-2 control-label">Nome</label>
                                <div className="col-sm-8">
                                    <input
                                        type="text"
                                        name="nickname"
                                        className="form-control"
                                        placeholder="Nickname"
                                        onChange={event => setName(event.target.value)}>
                                    </input>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-sm-2 control-label">Cpf</label>
                                <div className="col-sm-8">
                                    <input
                                        type="text"
                                        name="cpf"
                                        className="form-control"
                                        id="inputCpf"
                                        placeholder="CPF 000.000.000-00"
                                        onChange={event => setCpf(event.target.value)}>
                                    </input>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-sm-2 control-label">Data de Nascimento</label>
                                <div className="col-sm-8">
                                    <input
                                        type="date"
                                        name="dataNascimento"
                                        className="form-control"
                                        id="inputData"
                                        placeholder="99/99/9999"
                                        onChange={event => setDataNascimento(event.target.value)}>
                                    </input>
                                </div>
                            </div>
                            <div className="form-group">
                                <div className="col-sm-offset-1 col-sm-10">
                                    <button
                                        type="submit"
                                        className="btn btn-primary" 
                                        onClick={NotifyError}>
                                        Cadastrar
                                    </button>
                                    <ToastContainer />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )

}




export default CadastroPessoa;