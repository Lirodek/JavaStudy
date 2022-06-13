
import Customer from './components/Customer';
import './App.css';

const customers = [{
  'id':1,
  'image':'https://placeimg.com/64/64/1',
  'name':'배광민',
  'birthday':'990106',
  'gender':'남자',
  'job':'대학생'
},{
  'id':2,
  'image':'https://placeimg.com/64/64/2',
  'name':'홍길동',
  'birthday':'990106',
  'gender':'남자',
  'job':'대학생'
},{
  'id':3,
  'image':'https://placeimg.com/64/64/3',
  'name':'최광민',
  'birthday':'990106',
  'gender':'남자',
  'job':'대학생'
}]

function App() {
  return (
    <div>
      {
        customers.map(c => {
          return (
          <Customer
            key={c.id}
            id={c.id}
            image={c.image}
            name={c.namee}
            birthday={c.birthday}
            gender={c.gender}
            job={c.job}
          />
          )
        })
      }
    </div>
  );
}

export default App;
