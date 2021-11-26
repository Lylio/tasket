import { Typography } from 'antd';
import Layout, { Content, Header, Footer } from 'antd/lib/layout/layout';
import styled from 'styled-components';
import { colors } from '../shared/SharedUtils';
import Taskboard from '../taskboard/Taskboard';

const StyledLayout = styled(Layout)`
  /* We can't use "height: 100vh; width: 100vw;" here.
  Otherwise, when there is a horizontal scrollbar etc, 
  because that we set a constant height, there will be a vertical one too.  */
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
`;

const StyledHeader = styled(Header)`
  display: flex;
  align-items: center;
  background-color: #b2daf1;
`;

const StyledFooter = styled(Footer)`
  display: flex;
  align-items: center;
  background-color: #b2daf1;
  text-align: center;
`;

const StyledContent = styled(Content)`
  background-color: ${colors.primary[3]};
`;

function App() {
  return (
    <StyledLayout>
      <StyledHeader>
        <Typography.Title level={3} type="secondary">
          <a href="/">Tasket 📝</a>
        </Typography.Title>
      </StyledHeader>
      <StyledContent>
        <Taskboard />
      </StyledContent>
      <StyledFooter>
        <div
          style={{
            fontSize: '1em',
            color: '#567891',
            textAlign: 'center',
            fontWeight: 'bold',
            margin: 'auto'
          }}
        >
          ©2021 <a href="https://www.linkedin.com/in/lylechristine/">LYLE CHRISTINE</a>
        </div>
      </StyledFooter>
    </StyledLayout>
  );
}

export default App;
