package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class BidRequestMessage(bidIDField:Option[BidIDField]=None,
                             clientBidIDField:ClientBidIDField,
                             bidRequestTransTypeField:BidRequestTransTypeField,
                             listNameField:Option[ListNameField]=None,
                             totNoRelatedSymField:TotNoRelatedSymField,
                             bidTypeField:BidTypeField,
                             numTicketsField:Option[NumTicketsField]=None,
                             currencyField:Option[CurrencyField]=None,
                             sideValue1Field:Option[SideValue1Field]=None,
                             sideValue2Field:Option[SideValue2Field]=None,
                             noBidDescriptorsField:Option[NoBidDescriptorsField]=None,
                             bidDescriptorsGroups: Option[List[BidDescriptorsGroup]]=None,
                             noBidComponentsField:Option[NoBidComponentsField]=None,
                             bidComponentsGroups: Option[List[BidComponentsGroup]]=None,
                             liquidityIndTypeField:Option[LiquidityIndTypeField]=None,
                             wtAverageLiquidityField:Option[WtAverageLiquidityField]=None,
                             exchangeForPhysicalField:Option[ExchangeForPhysicalField]=None,
                             outMainCntryUIndexField:Option[OutMainCntryUIndexField]=None,
                             crossPercentField:Option[CrossPercentField]=None,
                             progRptReqsField:Option[ProgRptReqsField]=None,
                             progPeriodIntervalField:Option[ProgPeriodIntervalField]=None,
                             incTaxIndField:Option[IncTaxIndField]=None,
                             forexReqField:Option[ForexReqField]=None,
                             numBiddersField:Option[NumBiddersField]=None,
                             tradeDateField:Option[TradeDateField]=None,
                             bidTradeTypeField:BidTradeTypeField,
                             basisPxTypeField:BasisPxTypeField,
                             strikeTimeField:Option[StrikeTimeField]=None,
                             textField:Option[TextField]=None,
                             encodedTextLenField:Option[EncodedTextLenField]=None,
                             encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("k")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noBidDescriptorsField.map(_.value).getOrElse(0) != bidDescriptorsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoBidDescriptorsField.TagId,noBidDescriptorsField.map(_.value).getOrElse(0), bidDescriptorsGroups.map(_.size).getOrElse(0))
  if (noBidComponentsField.map(_.value).getOrElse(0) != bidComponentsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoBidComponentsField.TagId,noBidComponentsField.map(_.value).getOrElse(0), bidComponentsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    bidIDField.foreach(fmt(b,_))
    fmt(b,clientBidIDField)
    fmt(b,bidRequestTransTypeField)
    listNameField.foreach(fmt(b,_))
    fmt(b,totNoRelatedSymField)
    fmt(b,bidTypeField)
    numTicketsField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    sideValue1Field.foreach(fmt(b,_))
    sideValue2Field.foreach(fmt(b,_))
    noBidDescriptorsField.foreach(fmt(b,_))
    bidDescriptorsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noBidComponentsField.foreach(fmt(b,_))
    bidComponentsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    liquidityIndTypeField.foreach(fmt(b,_))
    wtAverageLiquidityField.foreach(fmt(b,_))
    exchangeForPhysicalField.foreach(fmt(b,_))
    outMainCntryUIndexField.foreach(fmt(b,_))
    crossPercentField.foreach(fmt(b,_))
    progRptReqsField.foreach(fmt(b,_))
    progPeriodIntervalField.foreach(fmt(b,_))
    incTaxIndField.foreach(fmt(b,_))
    forexReqField.foreach(fmt(b,_))
    numBiddersField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    fmt(b,bidTradeTypeField)
    fmt(b,basisPxTypeField)
    strikeTimeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object BidRequestMessage extends SfFixMessageDecoder {
  val MsgType="k"
  val MsgName="BidRequest"
             
  override val MandatoryFields = HashSet[Int](
    ClientBidIDField.TagId, BidRequestTransTypeField.TagId, TotNoRelatedSymField.TagId, BidTypeField.TagId, BidTradeTypeField.TagId, 
    BasisPxTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    BidDescriptorsGroup.isMandatoryField(tagId) || BidComponentsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    BidIDField.TagId, ListNameField.TagId, NumTicketsField.TagId, CurrencyField.TagId, SideValue1Field.TagId, 
    SideValue2Field.TagId, NoBidDescriptorsField.TagId, NoBidComponentsField.TagId, LiquidityIndTypeField.TagId, WtAverageLiquidityField.TagId, 
    ExchangeForPhysicalField.TagId, OutMainCntryUIndexField.TagId, CrossPercentField.TagId, ProgRptReqsField.TagId, ProgPeriodIntervalField.TagId, 
    IncTaxIndField.TagId, ForexReqField.TagId, NumBiddersField.TagId, TradeDateField.TagId, StrikeTimeField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    BidDescriptorsGroup.isOptionalField(tagId) || BidComponentsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    BidDescriptorsGroup.isFieldOf(tagId) || BidComponentsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoBidDescriptorsField.TagId, NoBidComponentsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==BidIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(BidRequestMessage(myFields.get(BidIDField.TagId).flatMap(f=>BidIDField.decode(f)),
        ClientBidIDField.decode(myFields.get(ClientBidIDField.TagId)).get,
        BidRequestTransTypeField.decode(myFields.get(BidRequestTransTypeField.TagId)).get,
        myFields.get(ListNameField.TagId).flatMap(f=>ListNameField.decode(f)),
        TotNoRelatedSymField.decode(myFields.get(TotNoRelatedSymField.TagId)).get,
        BidTypeField.decode(myFields.get(BidTypeField.TagId)).get,
        myFields.get(NumTicketsField.TagId).flatMap(f=>NumTicketsField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(SideValue1Field.TagId).flatMap(f=>SideValue1Field.decode(f)),
        myFields.get(SideValue2Field.TagId).flatMap(f=>SideValue2Field.decode(f)),
        myFields.get(NoBidDescriptorsField.TagId).flatMap(f=>NoBidDescriptorsField.decode(f)),
        if (nextTagPosLookup.contains(NoBidDescriptorsField.TagId)) BidDescriptorsGroup.decode(flds, nextTagPosLookup(NoBidDescriptorsField.TagId)) else None,
        myFields.get(NoBidComponentsField.TagId).flatMap(f=>NoBidComponentsField.decode(f)),
        if (nextTagPosLookup.contains(NoBidComponentsField.TagId)) BidComponentsGroup.decode(flds, nextTagPosLookup(NoBidComponentsField.TagId)) else None,
        myFields.get(LiquidityIndTypeField.TagId).flatMap(f=>LiquidityIndTypeField.decode(f)),
        myFields.get(WtAverageLiquidityField.TagId).flatMap(f=>WtAverageLiquidityField.decode(f)),
        myFields.get(ExchangeForPhysicalField.TagId).flatMap(f=>ExchangeForPhysicalField.decode(f)),
        myFields.get(OutMainCntryUIndexField.TagId).flatMap(f=>OutMainCntryUIndexField.decode(f)),
        myFields.get(CrossPercentField.TagId).flatMap(f=>CrossPercentField.decode(f)),
        myFields.get(ProgRptReqsField.TagId).flatMap(f=>ProgRptReqsField.decode(f)),
        myFields.get(ProgPeriodIntervalField.TagId).flatMap(f=>ProgPeriodIntervalField.decode(f)),
        myFields.get(IncTaxIndField.TagId).flatMap(f=>IncTaxIndField.decode(f)),
        myFields.get(ForexReqField.TagId).flatMap(f=>ForexReqField.decode(f)),
        myFields.get(NumBiddersField.TagId).flatMap(f=>NumBiddersField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        BidTradeTypeField.decode(myFields.get(BidTradeTypeField.TagId)).get,
        BasisPxTypeField.decode(myFields.get(BasisPxTypeField.TagId)).get,
        myFields.get(StrikeTimeField.TagId).flatMap(f=>StrikeTimeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     