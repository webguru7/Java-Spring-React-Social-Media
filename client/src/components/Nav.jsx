import {
  Box,
  useColorModeValue,
  Stack,
  Button,
} from '@chakra-ui/react';
import { useContext } from 'react';
import { BiHome } from 'react-icons/bi'
import AuthContext from '../context/AuthContext';
import NavItem from './NavItem';

function Nav() {

  const {logout} = useContext(AuthContext)

  return (
    <Box top={{lg:4}} zIndex={1} w={{ sm: "100%", lg: '30vh' }} position={{ sm:'sticky', lg: 'fixed' }} px={5}>
      <Stack
        bg={'white'}
        color={useColorModeValue('gray.600', 'white')}
        borderRadius={"2xl"}
        spacing={'10'}
        p={'15px'}
        pt={{lg:'10vh'}}
        h={{ sm: '20', lg: '95vh' }}
        direction={{ sm: 'row', lg: 'column' }}
        boxShadow={'2xl'}
      >
        <NavItem description={'Home'} icon={<BiHome/>}/>
        <NavItem description={'Home'} icon={<BiHome/>}/>
        <NavItem description={'Home'} icon={<BiHome/>}/>
        <Button colorScheme={'facebook'} onClick={()=>logout()}>
          Log out
        </Button>
      </Stack>
    </Box>
  )
}

export default Nav