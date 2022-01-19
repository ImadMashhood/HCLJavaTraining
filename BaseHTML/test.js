const emps=[
    {eno:111,ename:'Justin' },
    {eno:112,ename:'Lee' }
]

function getEmps(){
    setTimeout(()=>{
        let output='';
        emps.forEach((emp,index)=>{
            output+=`<li>${emp.ename}</li>`;
        });
        document.body.innerHTML=output;
    },1000)
}

function  createEmp(emp,callback){
    setTimeout(()=>{
        emps.push(emp);
        callback();
    },2000)
}

 
createEmp({eno:113,ename:'Harsh' },getEmps)