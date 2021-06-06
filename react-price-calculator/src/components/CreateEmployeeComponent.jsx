import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService';

class CreateEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            penguinEarsUnit: '',
            horseshoeUnit: ''            
        }
        this.changePenguinEarsUnitHandler = this.changePenguinEarsUnitHandler.bind(this);
        this.changeHorseshoeUnitHandler = this.changeHorseshoeUnitHandler.bind(this);
        this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            EmployeeService.getEmployeeById(this.state.id).then( (res) =>{
                let productPrice = res.data;
                this.setState({penguinEarsUnit: productPrice.penguinEarsUnit,
                    horseshoeUnit: productPrice.horseshoeUnit,
                    amount : productPrice.amount,
                    penguinEarsPrice : productPrice.penguinEarsPrice,
                    horseshoePrice : productPrice.horseshoePrice
                });
            });
        }        
    }
    saveOrUpdateEmployee = (e) => {
        e.preventDefault();
        let productPrice = {penguinEarsCount: this.state.penguinEarsUnit, horseshoeCount: this.state.horseshoeUnit};
        console.log('productPrice => ' + JSON.stringify(productPrice));

        // step 5
        if(this.state.id === '_add'){
            EmployeeService.createEmployee(productPrice).then(res =>{

                console.log(res.message);
                this.state.penguinEarsUnit = res.data.penguinEarsCount;
                this.state.horseshoeUnit = res.data.horseshoeCount;
                this.state.amount = res.data.amount;
                this.state.penguinEarsPrice = res.data.penguinEarsPrice;
                this.state.horseshoePrice = res.data.horseshoePrice;
                this.props.history.push('/add-productPrice/_add');
            });
        }else{
            EmployeeService.updateEmployee(productPrice, this.state.id).then( res => {
                this.props.history.push('/productPrices');
            });
        }
    }
    
    changePenguinEarsUnitHandler= (event) => {
        this.setState({penguinEarsUnit: event.target.value});
    }

    changeHorseshoeUnitHandler= (event) => {
        this.setState({horseshoeUnit: event.target.value});
    }

    changeAmountHandler= (event) => {
        this.setState({amount: event.target.value});
    }

    changeHorseshoeHandler= (event) => {
        this.setState({horseshoePrice: event.target.value});
    }

    changePenguinHandler= (event) => {
        this.setState({penguinEarsPrice: event.target.value});
    }

    cancel(){
        this.props.history.push('/productPrices');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Employee</h3>
        }else{
            return <h3 className="text-center">Update Employee</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {/* {
                                    this.getTitle()
                                } */}
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Penguin-ears units: </label>
                                            <input placeholder="Penguin-ears units" name="firstName" className="form-control" 
                                                value={this.state.penguinEarsUnit} onChange={this.changePenguinEarsUnitHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label>  Horseshoe units: </label>
                                            <input placeholder="Horseshoe units" name="lastName" className="form-control" 
                                                value={this.state.horseshoeUnit} onChange={this.changeHorseshoeUnitHandler}/>
                                        </div>
                                        

                                        
                                        <button className="btn btn-success" onClick={this.saveOrUpdateEmployee}>Calculate</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>History Log</button>
                                        <div className = "form-group">
                                            <label> </label>
                                            
                                        </div>
                                        
                                        <div className = "row">
                                            <label> Penguin-ears Price :  </label>
                                            <div> { this.state.penguinEarsPrice }</div>
                                        </div>
                                        <div className = "row">
                                            <label> Horseshoe Price:  </label>
                                            <div> { this.state.horseshoePrice }</div>
                                        </div>
                                        <div className = "row">
                                            <label> Total Price :  </label>
                                            <div> {this.state.amount }</div>
                                        </div>

                                        {/* <div className = "form-group">
                                            <label> Penguin-ears Price: </label>
                                            <input placeholder="Penguin-ears Price" name="penguin" className="form-control" 
                                                value={this.state.penguinEarsPrice} onChange={this.changePenguinHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Horseshoe Price: </label>
                                            <input placeholder="Horseshoe Price" name="horseshoe" className="form-control" 
                                                value={this.state.horseshoePrice} onChange={this.changeHorseshoeHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Total Price: </label>
                                            <input placeholder="Total Price" name="emailId" className="form-control" 
                                                value={this.state.emailId} onChange={this.changeEmailHandler}/>
                                        </div> */}
                                    </form>
                                    
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateEmployeeComponent
