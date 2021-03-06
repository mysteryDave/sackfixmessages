package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class CrossOrderCancelRequestMessage(orderIDField:Option[OrderIDField]=None,
                                          crossIDField:CrossIDField,
                                          origCrossIDField:OrigCrossIDField,
                                          crossTypeField:CrossTypeField,
                                          crossPrioritizationField:CrossPrioritizationField,
                                          sideCrossOrdCxlGrpComponent:SideCrossOrdCxlGrpComponent,
                                          instrumentComponent:InstrumentComponent,
                                          undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                          instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                          transactTimeField:TransactTimeField,
                                          hostCrossIDField:Option[HostCrossIDField]=None,
                                          rootPartiesComponent:Option[RootPartiesComponent]=None) extends SfFixMessageBody("u")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    fmt(b,crossIDField)
    fmt(b,origCrossIDField)
    fmt(b,crossTypeField)
    fmt(b,crossPrioritizationField)
    fmt(b,sideCrossOrdCxlGrpComponent)
    fmt(b,instrumentComponent)
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    hostCrossIDField.foreach(fmt(b,_))
    rootPartiesComponent.foreach(fmt(b,_))
    b
  }

}
     
object CrossOrderCancelRequestMessage extends SfFixMessageDecoder {
  val MsgType="u"
  val MsgName="CrossOrderCancelRequest"
             
  override val MandatoryFields = HashSet[Int](
    CrossIDField.TagId, OrigCrossIDField.TagId, CrossTypeField.TagId, CrossPrioritizationField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SideCrossOrdCxlGrpComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || 
    RootPartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, HostCrossIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SideCrossOrdCxlGrpComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || 
    RootPartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SideCrossOrdCxlGrpComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || 
    InstrmtLegGrpComponent.isFieldOf(tagId) || RootPartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(CrossOrderCancelRequestMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        CrossIDField.decode(myFields.get(CrossIDField.TagId)).get,
        OrigCrossIDField.decode(myFields.get(OrigCrossIDField.TagId)).get,
        CrossTypeField.decode(myFields.get(CrossTypeField.TagId)).get,
        CrossPrioritizationField.decode(myFields.get(CrossPrioritizationField.TagId)).get,
        SideCrossOrdCxlGrpComponent.decode(flds, startPos).get,
        InstrumentComponent.decode(flds, startPos).get,
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(HostCrossIDField.TagId).flatMap(f=>HostCrossIDField.decode(f)),
        RootPartiesComponent.decode(flds, startPos)))
    } else None
  }

    
}
     