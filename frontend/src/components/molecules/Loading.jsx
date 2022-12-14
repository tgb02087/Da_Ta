import React from "react";
import styled from "styled-components";
import TranslucentBackground from "./../atoms/TranslucentBackground";

const Loading = ({ bgColor, text, textBgColor }) => {
	return (
		<TranslucentBackground bgColor={bgColor}>
			<LoadingImg src={`${process.env.PUBLIC_URL}/assets/images/common/loading_spinner2.gif`} alt="로딩중" />
			{text && <LoadingText textBgColor={textBgColor}>{text}</LoadingText>}
		</TranslucentBackground>
	);
};

const LoadingText = styled.div`
	font-size: 1.2rem;
	font-weight: bold;
	text-align: center;
	padding: 0.5rem 1rem 0.5rem 1rem;
	background-color: ${(props) => props.textBgColor};
	border-radius: 16px;

	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
`;

LoadingText.defaultProps = {
	textBgColor: "rgba(225, 190, 231, 0.7)",
};

const LoadingImg = styled.img`
	width: 10%;
	@media screen and (max-width: 1024px) {
		width: 20%;
	}
	@media screen and (max-width: 500px) {
		width: 40%;
	}
`;

export default Loading;
